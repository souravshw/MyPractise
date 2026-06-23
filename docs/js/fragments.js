document.addEventListener('DOMContentLoaded', () => {
  const headerPlaceholder = document.getElementById('main-header');
  const footerPlaceholder = document.getElementById('main-footer');

  // Only fetch header dynamically if it is currently empty
  if (headerPlaceholder && headerPlaceholder.innerHTML.trim() === '') {
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

  // Only fetch footer dynamically if it is currently empty
  if (footerPlaceholder && footerPlaceholder.innerHTML.trim() === '') {
    const prefix = footerPlaceholder.getAttribute('data-path-prefix') || '';
    
    fetch(prefix + 'fragments/footer.html')
      .then(response => response.text())
      .then(html => {
        const processedHtml = html.replace(/{prefix}/g, prefix);
        footerPlaceholder.innerHTML = processedHtml;
      })
      .catch(err => console.error('Error loading footer:', err));
  }

  // Keyboard navigation for Next & Previous posts
  document.addEventListener('keydown', (e) => {
    // Skip if typing in input elements
    if (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA' || e.target.isContentEditable) {
      return;
    }
    
    if (e.key === 'ArrowLeft') {
      const prevLink = document.querySelector('.prev-card');
      if (prevLink) {
        // Add a temporary visual press effect before navigating
        prevLink.style.transform = 'scale(0.98)';
        setTimeout(() => {
          prevLink.click();
        }, 100);
      }
    } else if (e.key === 'ArrowRight') {
      const nextLink = document.querySelector('.next-card');
      if (nextLink) {
        // Add a temporary visual press effect before navigating
        nextLink.style.transform = 'scale(0.98)';
        setTimeout(() => {
          nextLink.click();
        }, 100);
      }
    }
  });

  // Inject Floating Controller Pad at the Bottom-Right for Blog Post Pages
  if (window.location.pathname.includes('/posts/') || document.querySelector('.article-container')) {
    // 1. Inject Styles dynamically
    const style = document.createElement('style');
    style.textContent = `
      .blog-controller {
        position: fixed;
        bottom: 2rem;
        right: 2rem;
        display: grid;
        grid-template-columns: repeat(3, 42px);
        grid-template-rows: repeat(3, 42px);
        gap: 6px;
        background: rgba(255, 255, 255, 0.75);
        backdrop-filter: blur(12px);
        -webkit-backdrop-filter: blur(12px);
        border: 1px solid var(--border-color);
        border-radius: 50%;
        padding: 10px;
        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08);
        z-index: 1000;
        transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
        align-items: center;
        justify-content: center;
      }
      .blog-controller:hover {
        box-shadow: var(--shadow-hover);
        transform: translateY(-2px);
        background: rgba(255, 255, 255, 0.85);
      }
      .controller-btn {
        display: flex;
        align-items: center;
        justify-content: center;
        width: 40px;
        height: 40px;
        border-radius: 50%;
        border: none;
        background: rgba(0, 0, 0, 0.03);
        color: var(--text-primary);
        cursor: pointer;
        transition: all 0.25s cubic-bezier(0.4, 0, 0.2, 1);
      }
      .controller-btn:hover:not(:disabled) {
        background-color: var(--accent-color);
        color: #fff;
        transform: scale(1.1);
      }
      .controller-btn:active:not(:disabled) {
        transform: scale(0.95);
      }
      .controller-btn:disabled {
        opacity: 0.2;
        cursor: not-allowed;
      }
      .btn-up { grid-column: 2; grid-row: 1; }
      .btn-left { grid-column: 1; grid-row: 2; }
      .btn-center {
        grid-column: 2;
        grid-row: 2;
        display: flex;
        align-items: center;
        justify-content: center;
      }
      .btn-center-dot {
        width: 6px;
        height: 6px;
        background-color: var(--accent-color);
        border-radius: 50%;
        opacity: 0.6;
      }
      .btn-right { grid-column: 3; grid-row: 2; }
      .btn-down { grid-column: 2; grid-row: 3; }
      
      @media (max-width: 640px) {
        .blog-controller {
          bottom: 1.5rem;
          right: 1.5rem;
          transform: scale(0.85);
        }
        .blog-controller:hover {
          transform: scale(0.85) translateY(-2px);
        }
      }
    `;
    document.head.appendChild(style);

    // 2. Create Controller Element
    const controller = document.createElement('div');
    controller.className = 'blog-controller';
    controller.innerHTML = `
      <button class="controller-btn btn-up" title="Scroll One Screen Up" aria-label="Scroll Up">
        <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><polyline points="18 15 12 9 6 15"></polyline></svg>
      </button>
      <button class="controller-btn btn-left" title="Previous Post" aria-label="Previous Post">
        <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><polyline points="15 18 9 12 15 6"></polyline></svg>
      </button>
      <div class="btn-center">
        <div class="btn-center-dot"></div>
      </div>
      <button class="controller-btn btn-right" title="Next Post" aria-label="Next Post">
        <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><polyline points="9 18 15 12 9 6"></polyline></svg>
      </button>
      <button class="controller-btn btn-down" title="Scroll One Screen Down" aria-label="Scroll Down">
        <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><polyline points="6 9 12 15 18 9"></polyline></svg>
      </button>
    `;
    document.body.appendChild(controller);

    // 3. Bind Actions
    const btnUp = controller.querySelector('.btn-up');
    const btnDown = controller.querySelector('.btn-down');
    const btnLeft = controller.querySelector('.btn-left');
    const btnRight = controller.querySelector('.btn-right');

    btnUp.addEventListener('click', () => {
      window.scrollBy({ top: -window.innerHeight, behavior: 'smooth' });
    });

    btnDown.addEventListener('click', () => {
      window.scrollBy({ top: window.innerHeight, behavior: 'smooth' });
    });

    const prevLink = document.querySelector('.prev-card');
    const nextLink = document.querySelector('.next-card');

    if (prevLink) {
      btnLeft.addEventListener('click', () => {
        // Visual click effect
        prevLink.style.transform = 'scale(0.98)';
        setTimeout(() => prevLink.click(), 100);
      });
    } else {
      btnLeft.disabled = true;
    }

    if (nextLink) {
      btnRight.addEventListener('click', () => {
        // Visual click effect
        nextLink.style.transform = 'scale(0.98)';
        setTimeout(() => nextLink.click(), 100);
      });
    } else {
      btnRight.disabled = true;
    }
  }
});
