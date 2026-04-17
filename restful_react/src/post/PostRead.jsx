import React, { useEffect, useState } from 'react';
import { Link, useParams, useNavigate } from 'react-router-dom';

const PostRead = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [postInfo, setPostInfo] = useState(null);

  useEffect(() => {
    const getPostInfo = async () => {
      const res = await fetch(`http://localhost:10000/api/posts/${id}`);
      const result = await res.json();
      setPostInfo(result.data);
    }
    getPostInfo();
  }, [])

  const deletePost = async () => {
    const res = await fetch(`http://localhost:10000/api/posts/${id}`, {
      method: "DELETE"
    })
    if (res.ok) {
      navigate("/posts/post-list");
    }
  }

  return (
    <div>
      {postInfo && (
        <>
          <p>제목: {postInfo.postTitle}</p>
          <p>내용: {postInfo.postContent}</p>
          <p>조회수: {postInfo.postReadCount}</p>
          <p>작성자: {postInfo.memberName} ({postInfo.memberEmail})</p>
          <Link to={`/posts/post-update/${id}`}>수정</Link>
          <button onClick={deletePost}>삭제</button>
        </>
      )}
    </div>
  );
};

export default PostRead;
