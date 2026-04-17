import { useForm } from 'react-hook-form';
import { useParams, useNavigate } from 'react-router-dom';

const PostUpdate = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const { register, handleSubmit, formState: { isSubmitting, errors } } = useForm({ mode: "onChange" });

  const update = handleSubmit(async (postUpdateRequestDTO) => {
    const res = await fetch(`http://localhost:10000/api/posts/update/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(postUpdateRequestDTO)
    })

    if (!res.ok) {
      const error = await res.json();
      alert(error?.message);
      return;
    }

    const result = await res.json();
    console.log(result.message);
    navigate(`/posts/post-read/${id}`);
  })

  return (
    <div>
      <form onSubmit={update}>
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
        <button disabled={isSubmitting}>수정 완료</button>
      </form>
    </div>
  );
};

export default PostUpdate;
