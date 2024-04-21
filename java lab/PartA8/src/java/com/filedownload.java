package com;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class filedownload extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/octet-stream");
        String filePath = "Documents\\six.txt";
        response.setHeader("Content-Disposition", "attachment; filename=\"six.txt\"");
        try (InputStream inputStream = new FileInputStream(filePath)) {
            try (OutputStream outputStream = response.getOutputStream()) {
                int bytesRead;
                byte[] buffer = new byte[4096];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "File Download Servlet";
    }
}