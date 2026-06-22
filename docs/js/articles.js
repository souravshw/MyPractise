document.addEventListener('DOMContentLoaded', () => {
  const articlesList = document.getElementById('articles-list');
  const categoryFilters = document.getElementById('category-filters');
  
  let activeCategory = 'all';

  // Render Category Filter Tabs dynamically (ALL categories from database)
  function renderCategoryFilters() {
    if (!categoryFilters || typeof postsData === 'undefined' || postsData.length === 0) return;

    // Collect ALL unique categories from the entire post database
    const categories = new Set();
    postsData.forEach(post => {
      if (post.category) {
        categories.add(post.category);
      }
    });

    // Re-build category filter HTML
    let html = `<button class="filter-tab active" data-category="all" id="filter-all">All</button>`;
    categories.forEach(cat => {
      const cleanId = cat.toLowerCase().replace(/[^a-z0-9]/g, '-');
      html += `<button class="filter-tab" data-category="${cat}" id="filter-${cleanId}">${cat}</button>`;
    });

    categoryFilters.innerHTML = html;
  }

  // Render Articles list (filtered by category, no limit constraint)
  function renderArticles(category = 'all') {
    if (!articlesList || typeof postsData === 'undefined') return;

    articlesList.innerHTML = '';
    
    const filteredPosts = category === 'all' 
      ? postsData 
      : postsData.filter(post => post.category === category);
      
    if (filteredPosts.length === 0) {
      articlesList.innerHTML = `<div style="color: var(--text-secondary); text-align: center;">No articles found in this category.</div>`;
      return;
    }
    
    filteredPosts.forEach(post => {
      const articleItem = document.createElement('div');
      articleItem.className = 'article-list-item';
      articleItem.style.paddingBottom = '1.25rem';
      articleItem.style.borderBottom = '1px solid var(--border-color)';
      
      articleItem.innerHTML = `
        <div class="post-meta" style="margin-bottom: 0.4rem; font-size: 0.8rem;">
          <span class="post-category" style="padding: 0.15rem 0.5rem; font-size: 0.7rem;">${post.category}</span>
          <span class="post-date">${post.date}</span>
          <span>&bull;</span>
          <span class="post-read-time">${post.readTime}</span>
        </div>
        <h2 style="font-size: 1.25rem; font-weight: 700; margin: 0; line-height: 1.4;">
          <a href="${post.url}" style="color: var(--text-primary); transition: var(--transition-smooth);" onmouseover="this.style.color='var(--accent-color)'" onmouseout="this.style.color='var(--text-primary)'">
            ${post.title}
          </a>
        </h2>
      `;
      
      articlesList.appendChild(articleItem);
    });
  }

  // Set up Tab Filtering
  if (categoryFilters) {
    categoryFilters.addEventListener('click', (e) => {
      const targetTab = e.target.closest('.filter-tab');
      if (!targetTab) return;
      
      // Remove active class from all tabs
      document.querySelectorAll('.filter-tab').forEach(tab => {
        tab.classList.remove('active');
      });
      
      // Add active class to clicked tab
      targetTab.classList.add('active');
      
      // Update active category state and re-render
      activeCategory = targetTab.dataset.category;
      renderArticles(activeCategory);
    });
  }

  // Initial Run
  renderCategoryFilters();
  renderArticles();

  // Handle category query parameter for filtering
  const urlParams = new URLSearchParams(window.location.search);
  const categoryParam = urlParams.get('category');
  if (categoryParam) {
    const filterBtn = Array.from(document.querySelectorAll('.filter-tab'))
      .find(btn => btn.dataset.category === categoryParam);
    if (filterBtn) {
      filterBtn.click();
    }
  }
});
