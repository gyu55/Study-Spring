import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

const PostList = () => {
  const [postList, setPostList] = useState([]);

  useEffect(() => {
    const getPostList = async () => {
      const res = await fetch("http://localhost:10000/api/posts");
      const result = await res.json();
      const { data } = result;
      setPostList(data);
    }
    getPostList();
  }, [])

  const posts = postList.map(({ id, postTitle, memberName }, i) => (
    <li key={i}>
      <Link to={`/posts/post-read/${id}`}>{postTitle}</Link> - {memberName}
    </li>
  ))

  return (
    <div>
      게시글 목록
      <Link to="/posts/post-write/22">글쓰기</Link>
      <ul>
        {posts}
      </ul>
    </div>
  );
};

export default PostList;
