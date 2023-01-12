let input_id;
let input_pwd;
let id_feedback;
let button_submit;

/**
 * This function will run once every DOM element is loaded
 * https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model/Introduction
 */
window.onload = function () {
    input_id = document.getElementById('id');
    input_pwd = document.getElementById('pwd');
    id_feedback = document.getElementById('id-feedback');
    button_submit = document.getElementById('form-submit-btn')
    let button_reset = document.getElementById('form-reset-btn');
    input_id.addEventListener('blur', e => validateId(e));
    input_pwd.addEventListener('blur', e => validatePassword(e));
    button_reset.addEventListener('click', () => resetValidity());
    resetValidity();
}

/**
 * Checks if input_id has valid and unique ID entry
 * and change form validity accordingly.
 */
function validateId(e) {
    let id_entry = e.target.value; // String

    if (id_entry.length <= 6) {
        changeValidity(input_id, false);
        id_feedback.innerText = (!id_entry) ? 'This field is empty!' : 'Too short id!';
        return;
    }

    // Fetch HTTP GET request. https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch
    let url = '/member/register/validate-id?';
    let query = new URLSearchParams({id: id_entry});
    fetch(url + query)
        .then((r) => {
            if (!r.ok)
                throw new Error(`HTTP Error ${r.status}: ${r.statusText}`);

            return r.text(); // Response is fetched into String (result)
        })
        .then((result) => changeValidity(input_id, result === 'true'));
}

/**
 * Checks if input_pwd has valid PASSWORD entry
 * and change form validity accordingly.
 */
function validatePassword(e) {
    let value = e.target.value;
    let valid = (value.length >= 6);
    changeValidity(input_pwd, valid);
}

function changeValidity(input, valid) {
    let add = valid ? 'is-valid' : 'is-invalid';
    let remove = valid ? 'is-invalid' : 'is-valid';
    input.classList.add(add);
    input.classList.remove(remove);
    input.innerText = 'This ID is already in use!'
    updateSubmitButton();
}

function resetValidity() {
    input_id.classList.remove('is-valid', 'is-invalid');
    input_pwd.classList.remove('is-valid', 'is-invalid');
    updateSubmitButton();
}

function updateSubmitButton() {
    let id_valid = input_id.classList.contains('is-valid');
    let pwd_valid = input_pwd.classList.contains('is-valid');
    button_submit.disabled = !(id_valid && pwd_valid);
}