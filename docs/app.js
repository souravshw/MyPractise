// Blog Posts Data Source
const postsData = [
  {
    id: 7,
    title: "Understanding Java's CompletableFuture: A Simple Walkthrough",
    excerpt: "Concurrency and asynchronous tasks don't have to be complicated. In this guide, we break down Java's CompletableFuture and thenCombine using a dinner prep analogy so you can write cleaner non-blocking programs.",
    category: "concepts",
    date: "June 18, 2026",
    readTime: "4 min read",
    url: "posts/understanding-completablefuture-simply.html"
  },
  {
    id: 6,
    title: "Demystifying Java's ForkJoinPool: A Simple Guide",
    excerpt: "Parallel processing doesn't have to be intimidating. In this guide, we break down Java's ForkJoinPool and RecursiveTask using a sandwich-making analogy so you can write high-performance multithreaded programs easily.",
    category: "concepts",
    date: "June 18, 2026",
    readTime: "4 min read",
    url: "posts/understanding-forkjoin-pool-simply.html"
  }
];

// DOM Elements
const postsList = document.getElementById('posts-list');
const categoryFilters = document.getElementById('category-filters');

// Initial State
let activeCategory = 'all';

// Render Posts Grid
function renderPosts(category = 'all') {
  postsList.innerHTML = '';
  
  const filteredPosts = category === 'all' 
    ? postsData 
    : postsData.filter(post => post.category === category);
    
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
});
