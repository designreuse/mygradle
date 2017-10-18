package com.git.util;

import javax.servlet.http.HttpServletRequest;

public class Page {

    public static String getPage(HttpServletRequest request, String appendString, int start, int range, long count) {
        String path = request.getRequestURI();

        //会返回刑辱： listDocumentCatalog.action的资源名 去掉查询字符串
        String requestedResourceName = path.substring(path.lastIndexOf("/") + 1);


        //总页数
        int numPages = (int) Math.ceil(count / range);

        if (numPages <= 1) {
            return "";
        }

        StringBuffer sb = new StringBuffer();

        //显示左箭头
        if (start > 0) {
            sb.append("<a href=\"").append(requestedResourceName).append("?");
//                   .append(appendString);

            //判断有没有搜索条件
            if ("".equals(appendString)) {
                sb.append("start=");
            } else {
                sb.append(appendString);
                sb.append("&start=");
            }

            sb.append(start - range);
            sb.append("&range=" + range);

            sb.append("\"").append(">").append(" <  ").append("</a>");
        }


        //当前页数
        int currentPage = start / range + 1;

        int low = currentPage - 5;
        if (low <= 0) {
            low = 1;
        }

        //加上...
        if (low > 2) {
            sb.append("<a href=\"").append(requestedResourceName).append("?");
            if ("".equals(appendString)) {
                sb.append("start=0");
            } else {
                sb.append(appendString);
                sb.append("&start=0");
            }

            sb.append("&range=" + range);

            sb.append("\"").append(">").append(" 1 ").append("</a>").append(" ... ");

        }

        while (low < currentPage) {
            sb.append("<a href=\"").append(requestedResourceName).append("?");
            if ("".equals(appendString)) {
                sb.append("start=");
            } else {
                sb.append(appendString);
                sb.append("&start=");
            }

            sb.append((low - 1) * range);
            sb.append("&range=" + range);
            sb.append("\"").append(">");
            sb.append(low);
            sb.append("</a>");

            low++;
        }

        //打印当前页
        sb.append("<b>");
        sb.append(currentPage);
        sb.append("</b>");


        // 打印当前页的后5页
        int hight = currentPage + 5;

        while ((currentPage <= hight) && (currentPage <= numPages)) {
            currentPage++;
            sb.append("<a href=\"").append(requestedResourceName).append("?");

            if ("".equals(appendString)) {
                sb.append("start=");
            } else {
                sb.append(appendString);
                sb.append("&start=");
            }

            sb.append((currentPage-1) * range);
            sb.append("&range=" + range);

            sb.append("\"").append(">");
            sb.append(currentPage);
            sb.append("</a>");



        }




        //最后一页
        if(hight+1 < numPages){
            sb.append(" ... ");
        }
        if (hight + 1 <= numPages) {

            sb.append("<a href=\"").append(requestedResourceName).append("?");
            if ("".equals(appendString)) {
                sb.append("start=");
            } else {
                sb.append(appendString);
                sb.append("&start=");
            }

//            sb.append(count - range);
            sb.append((numPages - 1) * range);
            sb.append("&range=" + range);
            sb.append("\"").append(">");
            sb.append(numPages);
            sb.append("</a>").append("&nbsp;");


        }

        //如果不在最后一页, 则显示向右箭头
        if(count > (start + range)) {
            sb.append("<a href=\"").append(requestedResourceName).append("?");
            if ("".equals(appendString)) {
                sb.append("start=");
            } else {
                sb.append(appendString);
                sb.append("&start=");
            }

            sb.append(start+range);
            sb.append("&range=" + range);
            sb.append("\"").append(">");
            sb.append("  > ");
            sb.append("</a>").append("&nbsp;");

        }



        return sb.toString();

    }
}
