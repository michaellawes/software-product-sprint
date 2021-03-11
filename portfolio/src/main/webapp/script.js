// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['You can\'t be the fastest in the West if you\'re the slowest in the East YEE YEE ', 'I have 3 first names', '\"There is no hope, no light, there is only despair\"', 'I listen to all types of music except country'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];
  
  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

async function showWeek2() {
  const responseFromServer = await fetch('/week-2');
  const json = await responseFromServer.json();
  const msg = json[Math.floor(Math.random() * json.length)];
  const fetchContainer = document.getElementById('fetch-container');
  fetchContainer.innerText = msg;
}

function loadFormResponses() {
  fetch('/list-responses').then(response => response.json()).then((formResponses) => {
    const responseListElement = document.getElementById('form-responses');
    formResponses.forEach((formResponse) => {
      responseListElement.appendChild(createResponseElement(formResponse));
    })
  });
}

function createResponseElement(formResponse) {
  const responseElement = document.createElement('li');
  responseElement.className = 'task';

  const nameElement = docuemnt.createElement('span');
  nameElement.innerText = formResponse.name;
  const emailElement = docuemnt.createElement('span');
  emailElement.innerText = formResponse.email;
  const subjectElement = docuemnt.createElement('span');
  subjectElement.innerText = formResponse.subject;
  const textElement = docuemnt.createElement('span');
  textElement.innerText = formResponse.text;

  const deleteResponseElemenet = document.createElement('button');
  deleteButtonElement.innerText = 'Delete';
  deleteButtonElement.addEventListener('click', () => {
    // Remove response from the DOM
    responseElement.remove();
  });

  responseElement.appendChild(nameElement);
  responseElement.appendChild(emailElement);
  responseElement.appendChild(subjectElement);
  responseElement.appendChild(textElement);
  responseElement.appendChild(deleteElement);
  return responseElement;
}
