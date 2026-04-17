import React from 'react';
import { createBrowserRouter } from 'react-router-dom';
import MemberList from '../member/MemberList';
import MemberInfo from '../member/MemberInfo';
import MemberJoin from '../member/MemberJoin';
import MemberLogin from '../member/MemberLogin';
import MemberUpdate from '../member/MemberUpdate';
import PostList from '../post/PostList';
import PostRead from '../post/PostRead';
import PostWrite from '../post/PostWrite';
import PostUpdate from '../post/PostUpdate';

const router = createBrowserRouter ([
  {
    path: "/members/member-list",
    element: <MemberList />
  },
  {
    path: "/members/member-info/:id",
    element: <MemberInfo />
  },
  {
    path: "/members/member-join",
    element: <MemberJoin />
  },
  {
    path: "/members/member-login",
    element: <MemberLogin />
  },
  {
    path: "/members/member-update/:id",
    element: <MemberUpdate />
  },
  {
    path: "/posts/post-list",
    element: <PostList />
  },
  {
    path: "/posts/post-read/:id",
    element: <PostRead />
  },
  {
    path: "/posts/post-write/:memberId",
    element: <PostWrite />
  },
  {
    path: "/posts/post-update/:id",
    element: <PostUpdate />
  }
])

export default router;