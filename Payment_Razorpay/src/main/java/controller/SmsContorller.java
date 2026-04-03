package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@WebServlet("/sms")
public class SmsContorller extends HttpServlet {
	
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				OkHttpClient client = new OkHttpClient();

				Request request = new Request.Builder()
				  .url("https://www.fast2sms.com/dev/bulkV2?authorization={key}&route=q&message=kanha&numbers=7383959727")
				  .get()
				  .addHeader("accept", "application/json")
				  .build();

				Response response = client.newCall(request).execute();
				
				
				
			}
}
