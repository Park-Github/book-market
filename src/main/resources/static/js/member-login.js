let input_id;
let input_pwd;
let button_submit;
let form;

/**
 * This function will run once every DOM element is loaded
 * https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model/Introduction
 */
window.addEventListener('load', () => {
    input_id = document.getElementById('id');
    input_pwd = document.getElementById('pwd');
    button_submit = document.getElementById('login-btn');
    form = document.getElementById('login-form');
    button_submit.addEventListener('click', () => onClick());
});

/**
 * Executes if user clicks 'Login' button
 */
async function onClick() {
    let id_match = await fetch_account(input_id);
    let pwd_match = await fetch_account(input_pwd);

    if (id_match && pwd_match) {
        form.submit();
    } else {
        window.alert('Account not found!');
    }
}

/**
 * Requests account validation to server
 * @param input Input element (e.g. input_id)
 * @returns {Promise<boolean>} Promise returns true if credential were matched correctly
 */
async function fetch_account(input) {
    let param = {};
    let url;

    switch (input) {
        case input_id:
            url = '/member/register/query-id?';
            param.id = input.value;
            break;
        case input_pwd:
            url = '/member/register/query-pwd?';
            param.id = input_id.value;
            param.password = input.value;
            break;
        default:
            throw new Error('Unknown type of input!');
    }
    let query = new URLSearchParams(param);
    let fetch_url = url + query;
    let response = await fetch(fetch_url);

    if (!response.ok) {
        throw new Error(`HTTP Error: ${response.status}`);
    }

    let text = await response.text();
    return (text === 'true');
}