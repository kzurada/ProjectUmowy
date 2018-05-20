<%@ page import="java.util.*, web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Umowy</title>
</head>

<%
	List<Umowy> theUmowy =
					(List<Umowy>) request.getAttribute("UMOWY_LIST");
%>

<body>

<%= theUmowy %>

	<div id="wrapper">
		<div id="header">
			<h2>Umowy</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>System</th>
					<th>Request</th>
					<th>Order_Number</th>
					<th>From_Date</th>
					<th>To_Date</th>
					<th>amount</th>
					<th>amount_Type</th>
					<th>amount_Period</th>
					<th>authorization_percent</th>
					<th>active</th>
				</tr>
				
				<%--<% for (Umowy tempUmowy : theUmowy) { %>
				
					<tr>
						<td> <%= tempUmowy.getSystem() %> </td>
						<td> <%= tempUmowy.getRequest() %> </td>
						<td> <%= tempUmowy.getOrder_number() %> </td>
						<td> <%= tempUmowy.getFrom_date() %> </td>
						<td> <%= tempUmowy.getTo_date() %> </td>
						<td> <%= tempUmowy.getAmount() %> </td>
						<td> <%= tempUmowy.getAmount_type() %> </td>
						<td> <%= tempUmowy.getAmount_period() %> </td>
						<td> <%= tempUmowy.getAuthorization_percent() %> </td>
						<td> <%= tempUmowy.getActive() %> </td>

					</tr>
				
				<% } %>--%>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








