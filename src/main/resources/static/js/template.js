class PageName extends HTMLElement {
    constructor() {
        super();

        const id = 'link-' + this.innerText.toLowerCase();
        let a = document.getElementById(id);
        this.innerText = null;

        if (a) {
            a.classList.add('active');
            a.setAttribute('aria-current', 'page');
        }
    }
}

window.addEventListener('load', () => {
    let logout_form = document.getElementById('logout-form');
    let logout_button = document.getElementById('logout-btn');

    if (logout_button) {

        logout_button.addEventListener('click', (e) => {
            e.preventDefault();
            logout_form.submit();
        });
    }
    customElements.define('page-name', PageName);
});
