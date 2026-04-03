package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/upload";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String uname = req.getParameter("uname");
        Part image = req.getPart("image");

        String iname = Paths.get(image.getSubmittedFileName())
                            .getFileName().toString();

    
        String path = req.getServletContext().getRealPath("/");
        String mypath = path+File.separator+"img";
        System.out.println(mypath);
        File f = new File(mypath);
        if(!f.exists())
        {
        	f.mkdir();
        }

        image.write(mypath+File.separator+iname);
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String sql = "INSERT INTO user VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setString(2, uname);
            ps.setString(3, iname);

            ps.executeUpdate();

           

            req.getRequestDispatcher("index.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}