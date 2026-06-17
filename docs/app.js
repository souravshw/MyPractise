// Blog Posts Data Source
const postsData = [
  {
    id: 1,
    title: "Understanding Promises: A Layman's Walkthrough",
    excerpt: "Asynchronous JavaScript can be tricky. In this guide, we break down JavaScript Promises using simple, real-world analogies (like ordering food at a restaurant) so you can finally understand how it works under the hood.",
    category: "javascript",
    date: "June 18, 2026",
    readTime: "5 min read",
    url: "posts/understanding-promises-simply.html"
  },
  {
    id: 2,
    title: "Python List Comprehensions Made Human-Readable",
    excerpt: "Stop writing multi-line for loops. Learn how to transform lists dynamically in Python with syntax that reads almost like english, explained step-by-step with clean code snippets.",
    category: "python",
    date: "June 15, 2026",
    readTime: "3 min read",
    url: "#"
  },
  {
    id: 3,
    title: "The Beginners Guide to CSS Grid Layouts",
    excerpt: "Grid layouts don't have to be confusing. Let's build a two-column sidebar website layout (like this blog!) using CSS grid from scratch in less than 5 minutes.",
    category: "webdev",
    date: "June 10, 2026",
    readTime: "4 min read",
    url: "#"
  },
  {
    id: 4,
    title: "Understanding the Stack and the Heap",
    excerpt: "Ever wondered where your variables go when your code executes? We compare Stack vs Heap memory allocations in simple visual analogies so you write more memory-efficient software.",
    category: "concepts",
    date: "June 05, 2026",
    readTime: "6 min read",
    url: "#"
  },
  {
    id: 5,
    title: "Asynchronous Programming: Event Loop Demystified",
    excerpt: "A deep dive into the JavaScript Event Loop, Call Stack, Callback Queue, and Microtask Queue. Perfect for beginners and developers preparing for technical interviews.",
    category: "javascript",
    date: "May 28, 2026",
    readTime: "7 min read",
    url: "#"
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
});
