/**
 * 
 */
window.onload = function(){
		//console.log("Hey what up? you crazy yet?");
		getLoginInfo();
}
function getLoginInfo() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if(xhttp.readyState == 4 && xhttp.status == 200) {
			let user = JSON.parse(xhttp.responseText);
			setValues(user);
			console.log(user);
		}
	}
	
	xhttp.open("GET", 'http://localhost:8080/TRMS/html/Home.do', true);
	xhttp.send();
	
}
function setValues(user) {
	document.getElementById("userId").innerHTML = "User ID: " + user.userId;
	document.getElementById("firstName").innerHTML = "First Name: " + user.firstName;
	document.getElementById("lastName").innerHTML = "Last Name: " + user.lastName;
	document.getElementById("dsId").innerHTML = "DS Id: " + user.dsId;
	document.getElementById("depId").innerHTML = "Dep Id: " + user.depId;
	for (i in user.tickets) {
		let current = user.tickets[i];
		for (x in current) {
			document.getElementById("tickets").innerHTML += x + ": " + current[x] + ", ";
		}
		document.getElementById("tickets").innerHTML += "<br>";
		let b = document.createElement("BUTTON");
		let c = document.createAttribute("class");
		c.value = "btn btn-primary btn-lg";
		b.setAttributeNode(c);
		c= document.createAttribute("id");
		c.value = current["ticketId"];
		b.setAttributeNode(c);
		document.getElementById("tickets").append(b);
		document.getElementById(current["ticketId"]).innerHTML = "Ticket Actions";
		document.getElementById("tickets").innerHTML += "<br>";
	}
	for (i in user.ticketsToApprove) {
		let current = user.ticketsToApprove[i];
		for (x in current) {
			document.getElementById("ticketsToApprove").innerHTML += x + ": " + current[x] + ", ";
		}
		document.getElementById("ticketsToApprove").innerHTML += "<br>";
		let b = document.createElement("A");
		let c = document.createAttribute("class");
		c.value = "btn btn-primary btn-lg";
		b.setAttributeNode(c);
		c= document.createAttribute("id");
		c.value = current["ticketId"];
		b.setAttributeNode(c);
		c = document.createAttribute("href");
		c.value = "http://localhost:8080/TRMS/html/Ticket.html";
		b.setAttributeNode(c);
		document.getElementById("ticketsToApprove").append(b);
		document.getElementById(current["ticketId"]).innerHTML = "Ticket Actions";
		document.getElementById("ticketsToApprove").innerHTML += "<br>";
	}
}

