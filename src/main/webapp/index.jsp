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
            <input type = "text" name = "phoneNumber" placeholder = "Patient Last name"/><br/>
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
		Api Calls Being Made and their results <br>
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
	$.fn.serializeObject = function()
	{
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	        if (o[this.name] !== undefined) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name].push(this.value || '');
	        } else {
	            o[this.name] = this.value || '';
	        }
	    });
	    return o;
	}
	</script>
	<script>
		$(function(e){
			
			$.get('api/sampleemr/patient/', function(data) {
				
				var tableData = "";
				
				for(var indice in data){
					var patientId = "<td>"+data[indice].patientId+"</td>";
					var patientFirstName = "<td>"+data[indice].patientFirstName+"</td>";
					var patientLastName = "<td>"+data[indice].patientLastName+"</td>";
					tableData+="<tr>"+patientId+patientFirstName+patientLastName+"</tr>";
				}
				
				$("#patients").append(tableData);
			});
			
			$("#patientForm").on('submit',function(e){
				e.preventDefault();
				
				$("#apiCall").append('');
				$("#apiCallResult").html('');
				
				var data = $(this).serializeObject();
				var url = $(this).attr('action');
				
				var strData =JSON.stringify(data);
				$.ajax({
		                type: "POST",
		                url: url,
		                data: strData,	
		                contentType: "application/json",
		                dataType: "json",
		                success: function (msg) {
		                    alert('success');
		                },
		                error:function(x,e){
		                    if(x.status==0){
		                        alert('error 0');
		                    }
		                }
		            });
				
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
