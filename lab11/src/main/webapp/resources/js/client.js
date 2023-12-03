async function getlist() {
    let response = await fetch('/lab11/getlist');

    if (response.ok) { // если HTTP-статус в диапазоне 200-299
      // получаем тело ответа (см. про этот метод ниже)
      let json = await response.json();
      console.log(json);
      let listdiv = document.getElementById("merchlist");
      let i;
      for (i = 0; i < json.length; i++) {
          let divchild = document.createElement('div');
          listdiv.append(divchild);
          divchild.innerHTML = json[i].name;
      }

    }
}

function connect(name) {

    let proto = window.location.protocol == 'http:' ? 'ws:' : 'wss:';
    console.log(proto + '//' + window.location.host );
    //webSocket = new WebSocket(proto + '//'  + window.location.host + '/msg/' + name);
    webSocket = new WebSocket('ws://localhost:8080/lab11/msg/' + name);

    webSocket.onmessage = function receiveMessage(response) {
        let data = response['data'];
        //let json = JSON.parse(data);
        console.log(data);
    };

    webSocket.onerror = function errorShow() {
        alert('Ошибка авторизации')
    }
}


document.addEventListener("DOMContentLoaded", () => {

    const dialog = document.querySelector("dialog");
    //const showButton = document.querySelector("dialog + button");
    const closeButton = document.querySelector("dialog button");

    // "Show the dialog" button opens the dialog modally
    showButton.addEventListener("click", () => {
      dialog.showModal();
    });

    // "Close" button closes the dialog
    closeButton.addEventListener("click", () => {
      dialog.close();
    });

    //let timerId = setInterval(async() => getlist(), 2000);

    connect('Kamil');
});

window.onunload = async function() {
    let response = await fetch('/lab11/unload');

    if (response.ok) { // если HTTP-статус в диапазоне 200-299
      // получаем тело ответа (см. про этот метод ниже)
      //let json = await response.json();
    }
};



