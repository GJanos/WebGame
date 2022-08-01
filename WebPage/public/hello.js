// port of spring boot which is open for requests
const PORT = 9089;
// base URL of spring boot
const BASEURL = `http://localhost:${PORT}/`;

const buttonString = document.querySelector(".button-primary");
const buttonCreate = document.querySelector(".button-secondary");
const buttonFetch = document.querySelector(".button-third");
const buttonUpdate = document.querySelector(".button-four");

buttonString.addEventListener("click", async (e) => {
  e.preventDefault();

  const objToSend = JSON.stringify({
    method: "STRING",
    buttonString: document.getElementById("nameField").value,
  });
  console.log(objToSend);

  fetch(`${BASEURL}test`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: objToSend,
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      buttonString.textContent = data.buttonString;
    })
    .catch((e) => console.error(e));
});

buttonCreate.addEventListener("click", async (e) => {
  e.preventDefault();
  const objToSend = JSON.stringify({
    method: "CREATE",
    buttonString: "create",
  });
  console.log(objToSend);

  fetch(`${BASEURL}create`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: objToSend,
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      const create = document.querySelector(".column");
      const input = document.createElement("input");
      input.type = Text;
      create.appendChild(input);
    })
    .catch((e) => console.error(e));
});

buttonFetch.addEventListener("click", async (e) => {
  e.preventDefault();

  const objToSend = JSON.stringify({
    method: "FETCH",
    buttonString: document.getElementById("nameField").value,
  });
  console.log(objToSend);

  fetch(`${BASEURL}fetch`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: objToSend,
  })
    .then((response) => response.json())
    .then((data) => {
      //place one input for each of the received datas
      console.log(data);
      buttonString.textContent = data.buttonString;
    })
    .catch((e) => console.error(e));
});

buttonUpdate.addEventListener("click", async (e) => {
  e.preventDefault();
  console.log("clicked update");
  fetch(`${BASEURL}update`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
  }).catch((e) => console.error(e));
});
