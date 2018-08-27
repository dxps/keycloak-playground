package com.example.news.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


@Controller
public class AppErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "error";
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorMsg = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        errorMsg = errorMsg == null || errorMsg.isEmpty() ? "n/a" : errorMsg;

        System.out.println(">>> AppErrorController > handleError: errorMsg=" + errorMsg);
        model.addAttribute("errorMsg", errorMsg);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return "error-403";
            } else if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        return "error";
    }

}
