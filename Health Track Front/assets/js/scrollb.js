window.addEventListener('scroll', () => {
    const header = document.querySelector('.header-top-b');
    header.classList.toggle('active-scroll-b', window.scrollY > 1)
})

window.addEventListener('scroll', () => {
    const header = document.querySelector('.header-aar');
    header.classList.toggle('active-scroll-b', window.scrollY > 1)
})