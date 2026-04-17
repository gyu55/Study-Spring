import React from 'react';
import { useForm } from 'react-hook-form';
import { useParams, useNavigate } from 'react-router-dom';

const MemberUpdate = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const {
    register, handleSubmit,
    formState: { isSubmitting, errors }
  } = useForm({ mode: "onChange" });

  const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[!@#])[\da-zA-Z!@#]{8,}$/;

  const update = handleSubmit(async (memberUpdateRequestDTO) => {
    const res = await fetch(`http://localhost:10000/api/members/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(memberUpdateRequestDTO)
    })

    if (!res.ok) {
      const error = await res.json()
      alert(error?.message)
      return
    }

    const result = await res.json()
    console.log(result.message)
    navigate(`/members/member-info/${id}`)
  })

  return (
    <div>
      <form onSubmit={update}>
        <div>
          <p>이름</p>
          <input {...register("memberName", {
            required: true 
          })} />
          {errors?.memberName && <p>이름을 입력하세요</p>}
        </div>
        <div>
          <p>비밀번호</p>
          <input
            type="password"
            {...register("memberPassword", {
              required: true,
              pattern: { value: passwordRegex }
            })}
          />
          {errors?.memberPassword?.type === "required" && <p>비밀번호를 입력하세요</p>}
          {errors?.memberPassword?.type === "pattern" && <p>소문자, 숫자, 특수문자를 각 하나씩 포함한 8자리 이상이어야 합니다</p>}
        </div>
        <button disabled={isSubmitting}>수정 완료</button>
      </form>
    </div>
  );
};

export default MemberUpdate;
