window.addEventListener('load', () => {
    let logout_form = document.getElementById('logout-form');
    let logout_button = document.getElementById('logout-btn');

    if (logout_button) {
        logout_button.addEventListener('click', (e) => {
            e.preventDefault();
            logout_form.submit();
        });
    }
});