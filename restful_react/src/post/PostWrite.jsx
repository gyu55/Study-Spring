import { useForm } from 'react-hook-form';
import { useParams, useNavigate } from 'react-router-dom';

const PostWrite = () => {
  const { memberId } = useParams();
  const navigate = useNavigate();

  const { register, handleSubmit, formState: { isSubmitting, errors } } = useForm({ mode: "onChange" });

  const write = handleSubmit(async (postWriteRequestDTO) => {
    const res = await fetch(`http://localhost:10000/api/posts/${memberId}`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(postWriteRequestDTO)
    })

    if (!res.ok) {
      const error = await res.json();
      alert(error?.message);
      return;
    }

    const result = await res.json();
    console.log(result.message);
    navigate("/posts/post-list");
  })

  return (
    <div>
      <form onSubmit={write}>
        <div>
          <p>제목</p>
          <input {...register("postTitle", { required: true })} />
          {errors?.postTitle && <p>제목을 입력하세요</p>}
        </div>
        <div>
          <p>내용</p>
          <textarea {...register("postContent", { required: true })} />
          {errors?.postContent && <p>내용을 입력하세요</p>}
        </div>
        <button disabled={isSubmitting}>작성 완료</button>
      </form>
    </div>
  );
};

export default PostWrite;
