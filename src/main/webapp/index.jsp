<!DOCTYPE html>
<html>
<body>
	<h2>Sample EMR</h2>
	<form id = "patientForm" method="POST" action="api/sampleemr/patient/add">
		<fieldset>
		   <legend>Add Patient</legend>
			<input type = "text" name = "patientId" placeholder = "Patient Id" /><br/>
			<input type = "text" name = "patientFirstName" placeholder = "Patient first Name"/><br/>
			<input type = "text" name = "patientLastName" placeholder = "Patient Last name"/><br/>
			<input type ="submit"/>
		</fieldset>
	</form>
	
	<div>
		<h5>Type an ID here to get a patient information in JSON</h5>
		<form id = "idForm" action = "api/sampleemr/patient/get/" method = "GET">
			<input type = "text" id = "searchId" placeholder ="put id here">
			<input type = "submit"/>
		</form>
		<br>
		<div>
		Api Calls and Api Result from the above form will be shown here <br>
		Api Call : <code id ="apiCall"> </code> <br>
		Result :   <code id = "apiCallResult"> </code>
		</div>
	</div>
	
	<div>
		<table  id = "patients">
			<tr>
				<th>Patient Id</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
		</table>
	</div>
	<script src ="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>
		$(function(e){
			
			$.get('api/sampleemr/patient/', function(data) {
				
				var tableData = "";
				
				for(var indice in data){
					var patientId = "<td>"+data[indice].patienId+"</td>";
					var patientFirstName = "<td>"+data[indice].patientFirstName+"</td>";
					var patientLastName = "<td>"+data[indice].patientLastName+"</td>";
					tableData+="<tr>"+patientId+patientFirstName+patientLastName+"</tr>";
				}
				
				$("#patients").append(tableData);
			});
			
			$("#patientForm").on('submit',function(e){
				e.preventDefault();
				
				var data = $(this).serialize();
				var url = $(this).attr('action');
				
				$.post(url,data,function(data){
					var patientId = "<td>"+data.patienId+"</td>";
					var patientFirstName = "<td>"+data.patientFirstName+"</td>";
					var patientLastName = "<td>"+data.patientLastName+"</td>";
					var tableData ="<tr>"+patientId+patientFirstName+patientLastName+"</tr>";
					$("#patients").append(tableData);
				})
				

				$(this).trigger("reset");
			})
			
			$("#idForm").on('submit',function(e){
				e.preventDefault();

				$("#apiCall").append('');
				$("#apiCallResult").html('');
				
				var url = $(this).attr('action');
				var data = $("#searchId").val();
			
				$("#apiCall").html(url+data);
				
				$.get(url+data,function(data){
					$("#apiCallResult").html(JSON.stringify(data));
				})
				

				$(this).trigger("reset");
			})
		})
	</script>
</body>
</html>
