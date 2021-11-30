function loginHide(){

document.addEventListener('mouseup', function(e) {
    var container = document.getElementById('card-login');
    if (!container.contains(e.target)) {
        container.style.display = 'none';
    }
});
}

function showAlert() {
    alert("The button was clicked!");
}