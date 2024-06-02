
async function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    

    if(username === 'user' && password === 'pass') {
      alert('Login Successful');
      document.getElementById('loginForm').style.display = 'none';
      document.getElementById('content').style.display = 'block';
      window.location.href = 'plano_carreira/dashboard';
    } else {
      alert('Login Failed');
    }

    
    axios.get('http://localhost:8080/login')
    .then(function (response) {
      response => response.data()
      console.log(response.data)
    })
    .catch(function (error) {
      console.log(error)

    })
  }

  function redirectToRegistration(){
    window.location.href = 'funcionario/cadastrar/cadastrar.html';
}
    

    