import React, { useEffect, useState } from 'react';
import { Link, useParams, useSearchParams } from 'react-router-dom';

const MemberInfo = () => {
	// 22번 회원 정보를 조회
	// 22번 회원 정보를 모두 화면에 출력
	const [memberInfo, setMemberInfo] = useState({});

	// 다이나믹 파라미터 useParams()
	// 쿼리스트링 useSearchParams()
	const {id} = useParams()
	console.log(id)

	useEffect(() => {
	const getMemberInfo = async() => {
		try {
			const response = await fetch(`http://localhost:10000/api/members/${id}`)
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

	// 회원탈퇴
	const withdraw = async() => {
		await fetch(`http://localhost:10000/api/members/${id}`, {
			method: "DELETE"
	})
	.then(async (res) => {
		if(!res.ok){
			const error = await res.json()
			throw new Error(error?.message)
		}
		return res.json()
	})
	.then((res) => {
		console.log(res)
	})
	.catch((err) => {
		console.log(err)
	})
	}

	return (
	<div>
		<p>회원 번호: {memberInfo?.id}</p>
		<p>회원 이름: {memberInfo?.memberName}</p>
		<p>회원 이메일: {memberInfo?.memberEmail}</p>
		<Link to={`/members/member-update/${id}`}>회원 정보 수정</Link>
		<button onClick={withdraw}>회원탈퇴</button>
	</div>
	);
};

export default MemberInfo;