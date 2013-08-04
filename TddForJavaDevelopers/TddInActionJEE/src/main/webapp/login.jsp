<%@page language="Java" %>
<html>
    <body>
        <form>
            <% 
                String username = (String) request.getAttribute("j_username");
                if (username == null) {
                    username = "";
                };
            %>
            <input type="text" name="j_username" />
            <input type="password" name="j_password" />
            <input type="submit" name="login" />
        </form>
    </body>
</html>