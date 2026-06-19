// Note: postsData is loaded from js/posts.js


// DOM Elements
const postsList = document.getElementById('posts-list');
const categoryFilters = document.getElementById('category-filters');
const featuredPost = document.getElementById('featured-post');

// Initial State
let activeCategory = 'all';

// Render Featured Post (Hero Card)
function renderFeaturedPost() {
  if (!featuredPost || postsData.length === 0) return;
  const latestPost = postsData[0];
  const imgContent = latestPost.image 
    ? `<img src="${latestPost.image}" alt="${latestPost.title}">` 
    : `<svg width="80" height="80" viewBox="0 0 24 24" fill="none" stroke="var(--accent-color)" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"><path d="M4 15s1-1 4-1 5 2 8 2 4-1 4-1V3s-1 1-4 1-5-2-8-2-4 1-4 1z"/><line x1="4" y1="22" x2="4" y2="15"/></svg>`;

  featuredPost.innerHTML = `
    <div class="hero-card">
      <div class="hero-img">
        ${imgContent}
      </div>
      <div class="hero-content">
        <div class="post-meta">
          <span class="post-category">${latestPost.category}</span>
          <span class="post-date">${latestPost.date}</span>
          <span>•</span>
          <span class="post-read-time">${latestPost.readTime}</span>
        </div>
        <h1 class="hero-title"><a href="${latestPost.url}" id="hero-link">${latestPost.title}</a></h1>
        <p class="hero-excerpt">${latestPost.excerpt}</p>
        <div>
          <a href="${latestPost.url}" class="read-more-btn" id="hero-read-more">Read walkthrough →</a>
        </div>
      </div>
    </div>
  `;
}

// Render Posts Grid
function renderPosts(category = 'all', limit = 10) {
  postsList.innerHTML = '';
  
  let filteredPosts = category === 'all' 
    ? postsData 
    : postsData.filter(post => post.category === category);
    
  if (limit) {
    filteredPosts = filteredPosts.slice(0, limit);
  }
    
  if (filteredPosts.length === 0) {
    postsList.innerHTML = `<div class="post-card" style="text-align: center; color: var(--text-secondary);">No articles found in this category yet.</div>`;
    return;
  }
  
  filteredPosts.forEach(post => {
    const postCard = document.createElement('article');
    postCard.className = 'post-card';
    postCard.innerHTML = `
      <div class="post-meta">
        <span class="post-category">${post.category}</span>
        <span class="post-date">${post.date}</span>
        <span>•</span>
        <span class="post-read-time">${post.readTime}</span>
      </div>
      <h2 class="post-card-title"><a href="${post.url}">${post.title}</a></h2>
      <p class="post-card-excerpt">${post.excerpt}</p>
      <div>
        <a href="${post.url}" class="read-more-btn">Read walkthrough →</a>
      </div>
    `;
    postsList.appendChild(postCard);
  });
}

// Render Category Filter Tabs dynamically on homepage based on visible posts (top 10)
function renderCategoryFilters() {
  if (!categoryFilters || typeof postsData === 'undefined' || postsData.length === 0) return;
  
  // Get categories from the first 10 posts
  const visiblePosts = postsData.slice(0, 10);
  const categories = new Set();
  visiblePosts.forEach(post => {
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
    renderPosts(activeCategory);
  });
}

// Initial Run
document.addEventListener('DOMContentLoaded', () => {
  renderCategoryFilters();
  renderFeaturedPost();
  renderPosts();
  
  // Cookie Consent Banner Logic
  const cookieBanner = document.getElementById('cookie-consent-banner');
  const btnAccept = document.getElementById('btn-cookie-accept');
  const btnDecline = document.getElementById('btn-cookie-decline');

  if (cookieBanner) {
    const consent = localStorage.getItem('cookieConsent');
    
    // If no consent has been registered, show the banner with a delay
    if (!consent) {
      setTimeout(() => {
        cookieBanner.classList.add('show');
      }, 1000);
    }

    btnAccept.addEventListener('click', () => {
      localStorage.setItem('cookieConsent', 'accepted');
      cookieBanner.classList.remove('show');
    });

    btnDecline.addEventListener('click', () => {
      localStorage.setItem('cookieConsent', 'declined');
      cookieBanner.classList.remove('show');
    });
  }

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
