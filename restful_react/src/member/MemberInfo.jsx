import React, { useEffect, useState } from 'react';

const MemberInfo = () => {
  // 22번 회원 정보를 조회
  // 22번 회원 정보를 모두 화면에 출력
  const [memberInfo, setMemberInfo] = useState({});

  useEffect(() => {
    const getMemberInfo = async() => {
      try {
        const response = await fetch("http://localhost:10000/api/members/22")
        if(!response.ok) throw new Error("회원 조회 실패")
        const result = await response.json()
        const {message, data} = result;
        setMemberInfo(data)
      } catch (err) {
        console.log(err.message)
      }
    }
    getMemberInfo()
  }, [])

  return (
    <div>
      <p>회원 번호: {memberInfo.id}</p>
      <p>회원 이름: {memberInfo.memberName}</p>
      <p>회원 이메일: {memberInfo.memberEmail}</p>
    </div>
  );
};

export default MemberInfo;