document.addEventListener('DOMContentLoaded', () => {
  const articlesList = document.getElementById('articles-list');
  
  if (articlesList && typeof postsData !== 'undefined') {
    if (postsData.length === 0) {
      articlesList.innerHTML = `<div style="color: var(--text-secondary); text-align: center;">No articles found.</div>`;
      return;
    }
    
    postsData.forEach(post => {
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
});
