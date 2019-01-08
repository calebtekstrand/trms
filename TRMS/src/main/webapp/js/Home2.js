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
	
	xhttp.open("GET", 'http://localhost:9091/TRMS/html/Home.do', true);
	xhttp.send();
	
}
function setValues(user) {
	document.getElementById("pic").href = user.base64;
	document.getElementById("myHeader").innerHTML = "Welcome " + user.firstName + " " + user.lastName;
//	for (i in user.tickets) {
//		let current = user.tickets[i];
//		for (x in current) {
//			document.getElementById("tickets").innerHTML += x + ": " + current[x] + ", ";
//		}
//		document.getElementById("tickets").innerHTML += "<br>";
//		let b = document.createElement("BUTTON");
//		let c = document.createAttribute("class");
//		c.value = "btn btn-primary btn-lg";
//		b.setAttributeNode(c);
//		c= document.createAttribute("id");
//		c.value = current["ticketId"];
//		b.setAttributeNode(c);
//		document.getElementById("tickets").append(b);
//		document.getElementById(current["ticketId"]).innerHTML = "Ticket Actions";
//		document.getElementById("tickets").innerHTML += "<br>";
//	}
	
}