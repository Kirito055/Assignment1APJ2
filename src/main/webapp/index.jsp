<%@include file="jsp/header.jsp"%> <%--There we include header.php--%>
<%String path = (String) request.getAttribute("Path");
%>
<div class="all">
    <h1 style="font-size:2vw;">Path Name: <%=path%></h1><%--There we can se path of the file--%>
</div>
<div class="all">

    <button >

    </button>

</div>
<div class="all"><%--In the down we show the list of files--%>

        <%
        ArrayList<AboutFile> files = (ArrayList<AboutFile>) request.getAttribute("ListFile");
        String str ="";
        try {
            for (AboutFile file1 : files) {
                str = file1.getPath();
                str = str.replace("\\", "%2F");
               out.println("<div class=\"files\">");
                if (file1.isFile()) {
                    out.println("<img src=\"https://icon-library.com/images/file-icon/file-icon-6.jpg\" class=\"d-block w-50\" alt=\"\">");
                } else {
                    out.println("<img src=\"https://cdn.onlinewebfonts.com/svg/img_720.png\" class=\"d-block w-50\" alt=\"\">");
                }
                out.println("<p style=\"font-size:1.2vw;\"> Name: " + file1.getName() + "</p>");

                out.println("</div>");
                out.println("</a>");
            }
        }
        catch (Exception e){
            System.out.println(e);
            try {
throw new Exception("Something went wrong");} catch (Exception exception) {
    exception.printStackTrace();
}
        }
    %>

<%@include file="jsp/footer.jsp"%><%--There we include footer.jsp--%>