let input_id;
let input_pwd;
let id_feedback;
let button_submit;

window.onload = function () {
    input_id = document.getElementById('id');
    input_pwd = document.getElementById('pwd');
    id_feedback = document.getElementById('id-feedback');
    button_submit = document.getElementById('form-submit-btn')
    let button_reset = document.getElementById('form-reset-btn');
    input_id.addEventListener('blur', e => validateId(e));
    input_pwd.addEventListener('blur', e => validatePassword(e));
    button_reset.addEventListener('click', () => resetValidations());
    resetValidations();
}

function validateId(e) {
    let target = e.target;
    let value = target.value;

    if (!value) {
        changeValidity(input_id, false);
        id_feedback.innerText = 'This field is empty!';
        return;
    }

    let query = new URLSearchParams({id: value});
    fetch('/member/register/validate-id?' + query)
        .then((r) => {
            if (!r.ok) {
                throw new Error(`HTTP Error ${r.status}: ${r.statusText}`);
            }
            return r.text();
        })
        .then((text) => {
            changeValidity(input_id, text === 'true');
        });
}

function validatePassword(e) {
    let value = e.target.value;
    let valid = value.length >= 6;
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

function resetValidations() {
    input_id.classList.remove('is-valid', 'is-invalid');
    input_pwd.classList.remove('is-valid', 'is-invalid');
    updateSubmitButton();
}

function updateSubmitButton() {
    let id_valid = input_id.classList.contains('is-valid');
    let pwd_valid = input_pwd.classList.contains('is-valid');
    button_submit.disabled = !(id_valid && pwd_valid);
}