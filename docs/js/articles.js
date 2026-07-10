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

  // Filter Articles list (filtered by category, toggling display of static elements)
  function filterArticles(category = 'all') {
    if (!articlesList) return;

    const items = articlesList.querySelectorAll('.article-list-item');
    let visibleCount = 0;
    
    items.forEach(item => {
      const itemCategory = item.dataset.category;
      if (category === 'all' || itemCategory === category) {
        item.style.display = '';
        visibleCount++;
      } else {
        item.style.display = 'none';
      }
    });

    // Remove any existing "No articles found" message
    const noResultsMsg = articlesList.querySelector('.no-results-message');
    if (noResultsMsg) {
      noResultsMsg.remove();
    }

    if (visibleCount === 0) {
      const msgDiv = document.createElement('div');
      msgDiv.className = 'no-results-message';
      msgDiv.style.color = 'var(--text-secondary)';
      msgDiv.style.textAlign = 'center';
      msgDiv.style.padding = '2rem 0';
      msgDiv.textContent = 'No articles found in this category.';
      articlesList.appendChild(msgDiv);
    }
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
      
      // Update active category state and filter
      activeCategory = targetTab.dataset.category;
      filterArticles(activeCategory);
    });
  }

  // Initial Run
  renderCategoryFilters();
  
  // Handle category query parameter for filtering
  const urlParams = new URLSearchParams(window.location.search);
  const categoryParam = urlParams.get('category');
  if (categoryParam) {
    const filterBtn = Array.from(document.querySelectorAll('.filter-tab'))
      .find(btn => btn.dataset.category === categoryParam);
    if (filterBtn) {
      filterBtn.click();
    } else {
      filterArticles();
    }
  } else {
    filterArticles();
  }
});
