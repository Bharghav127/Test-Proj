<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <h1 style="color:red, text-align=center">contact details</h1>
    
    
     <font color="green">${resmsg}</font>
    
    <br><br>
           <form:form name="contact-form" action="/save.htm?id=${cnctDtls.id}" method="POST" modelAttribute="cnctDtls">
      <table>
          <tr>
              <td>FirstName:</td>
              <td><form:input path="contactName" /></td>
          </tr>
          <tr>
              <td>Email Name:</td>
              <td><form:input path="email" /></td>
          </tr>
          <tr>
              <td>phoneNo:</td>
              <td><form:input path="phoneNo"/></td>
          </tr>
          <tr>
              <td colspan="2">
              <input type="reset" value="Reset" />
                  <input type="submit" value="SaveChanges" onclick="return clearform(this)" />
              </td>
          </tr>
      </table>
       
     <script type="text/javascript">
       function clearform() {
           alert("this 1");
	 document.FirstName.reset();
	}
}
</script>  
       
      <a href="showAll.htm">Show All Contacts</a>
  </form:form>
   

    
    