import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

// fetch로 회원 목록 api에 요청 후
// 회원의 이메일을 모두 화면에 출력하기

const MemberList = () => {
  // const [members, setMembers] = useState([]);
  const [memberList, setMemberList] = useState([]);

  useEffect(() => {
    const getMemberList = async() => {
      const response = await fetch("http://localhost:10000/api/members")
      const memberList = await response.json()
      const {message, data} = memberList;
      // return memberList
      setMemberList(data)
    }

    getMemberList()
  }, [])

  const memberNames = memberList.map(({memberName}, i) => (
    <li key={i}>{memberName}</li>
  ))

  // fetch('http://localhost:10000/api/members')
  //   .then(response => response.json())
  //   .then(result => {
  //     setMembers(result.data);
  //   }
  // );

  return (
        <div>
          회원 목록
          <ul>
            {memberNames}
          </ul>
        </div>

    // <table>
    //   <thead>
    //     <th>회원 번호</th>
    //     <th>회원 이름</th>
    //     <th>회원 이메일</th>
    //   </thead>
    //   <tbody>
    //     {members.map(member => (
    //       <tr key={member.id}>
    //         <td>{member.id}</td>
    //         <td>{member.memberName}</td>
    //         <td>{member.memberEmail}</td>
    //       </tr>
    //     ))}
    //   </tbody>
    // </table>
  );
};


export default MemberList;