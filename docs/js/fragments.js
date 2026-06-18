document.addEventListener('DOMContentLoaded', () => {
  const headerPlaceholder = document.getElementById('main-header');
  const footerPlaceholder = document.getElementById('main-footer');

  if (headerPlaceholder) {
    const prefix = headerPlaceholder.getAttribute('data-path-prefix') || '';
    const activeNav = headerPlaceholder.getAttribute('data-active-nav');
    
    fetch(prefix + 'fragments/header.html')
      .then(response => response.text())
      .then(html => {
        const processedHtml = html.replace(/{prefix}/g, prefix);
        headerPlaceholder.innerHTML = processedHtml;
        
        if (activeNav) {
          const activeLink = document.getElementById('nav-' + activeNav);
          if (activeLink) {
            activeLink.classList.add('active');
          }
        }
      })
      .catch(err => console.error('Error loading header:', err));
  }

  if (footerPlaceholder) {
    const prefix = footerPlaceholder.getAttribute('data-path-prefix') || '';
    
    fetch(prefix + 'fragments/footer.html')
      .then(response => response.text())
      .then(html => {
        const processedHtml = html.replace(/{prefix}/g, prefix);
        footerPlaceholder.innerHTML = processedHtml;
      })
      .catch(err => console.error('Error loading footer:', err));
  }
});
