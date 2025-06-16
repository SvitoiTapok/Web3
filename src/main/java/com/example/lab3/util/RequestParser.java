package com.example.lab3.util;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class RequestParser {
    //public static void main(String[] args) {
    //    var fcgiInterface = new FCGIInterface();
//
    //    while (fcgiInterface.FCGIaccept() >= 0) {
    //        Instant start = Instant.now();
    //        Properties fcgiInfo = FCGIInterface.request.params;
    //        String request = fcgiInfo.getProperty("QUERY_STRING");
    //        if(checkRequest(request)){
    //            int[] params = parseRequest(request);
    //            if(hitCheck(params)){
    //                long duration = getTime(start);
    //                String response = ResponseBuilder.buildResponse(params, true, duration);
    //                System.out.println(response);
    //            }else {
    //                long duration = getTime(start);
    //                String response = ResponseBuilder.buildResponse(params, false, duration);
    //                System.out.println(response);
    //            }
    //        }else {
    //            String response = ResponseBuilder.buildErrorResponse();
    //            System.out.println(response);
    //        }
    //    }
    //}


    static boolean checkRequest(String request){
        String regRequestX = "^x=.*$";
        String regRequestY = "^y=.*$";
        String regRequestR = "^r=.*$";
        Pattern patternX = Pattern.compile(regRequestX);
        Pattern patternY = Pattern.compile(regRequestY);
        Pattern patternR = Pattern.compile(regRequestR);
        boolean Xreq=false; boolean Yreq=false;  boolean Rreq=false;
        String[] params = request.split("&");
        if(params.length!=3) return false;
        for(String param : params){
            try {
                if (patternX.matcher(param).matches()) {
                    Xreq = Double.parseDouble(param.substring(2))>=-4 && Double.parseDouble(param.substring(2))<=4;
                }
                if (patternY.matcher(param).matches()) {
                    Yreq = Double.parseDouble(param.substring(2))>=-3 && Double.parseDouble(param.substring(2))<=3;
                }
                if (patternR.matcher(param).matches()) {
                    Rreq = Double.parseDouble(param.substring(2))>=1 && Double.parseDouble(param.substring(2))<=4;
                }
            }catch (NumberFormatException e){
                return false;
            }
        }
        return Xreq&&Yreq&&Rreq;

    }


    static double[] parseRequest(String request){
        double[] params = new double[3];
        String[] pars = request.split("&");
        for (String par : pars) {
            if (par.contains("x")) params[0] = Double.parseDouble(par.substring(2));
            if (par.contains("y")) params[1] = Double.parseDouble(par.substring(2));
            if (par.contains("r")) params[2] = Double.parseDouble(par.substring(2));
        }
        return params;
    }





    public static String getCurretnTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
    public static boolean hitCheck(double x, double y, double r){
        if(x>=0 && y>=0 && x*x+y*y<=r*r/4){
            return true;
        }
        if (x>=0 && y<=0 && y>=-r/2.0 && x<=r){
            return true;
        }
        if(x<=0 && y<=0 && y>=-x-r){
            return true;
        }
        return false;
    }

    public static long getTime(Instant instant){
        return java.time.Duration.between(instant, Instant.now()).toNanos();
    }


}