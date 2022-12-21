import axios from "axios";
import React, { useState } from "react";
import { RiCloseLine } from "react-icons/ri";

export default function ForgotPassword(props) {
  const [email, setEmail] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post("vårat api här", { email })
      .then((res) => setMessage(res.data.message))
      .catch((err) => setMessage(err.response.data.message));
  };

  return (
    <>
      <div className="w-screen h-screen bg-gray-500 bg-opacity-70 fixed top-0 left-0 z-10" />
      <div className="bg-gray-500 bg-opacity-70 top-0 left-0 fixed w-screen h-screen justify-center items-center flex flex-row rounded z-20">
        <form onSubmit={handleSubmit} className="bg-white fixed inset-0 items-center justify-center w-max h-max m-auto rounded">
          <div className="flex border-b-2 px-6 py-4 items-center justify-between align-middle">
            <div className="w-min whitespace-nowrap">
                <h1 className="text-2xl">Glömt lösenord</h1>
            </div>
            <div className="w-min text-right flex justify-end">
              <button
                className="text-3xl opacity-70 hover:opacity-100 duration-300"
                onClick={() => props.setIsChangePasswordOpen(false)}
              >
                <RiCloseLine />
              </button>
            </div>
          </div>
          <div className="w-full shadow-lg rounded-md p-6">
            <div className="w-full gap-2 text-white">
              <label className="block text-sm font-medium text-gray-700">
                Email:
                <input
                  type={email}
                  value={email}
                  className="rounded block w-full mt-2 p-2.5 border-gray-500 border text-black focus:outline-none focus:border-sky-500 focus:ring-1 focus:ring-sky-500"
                  onChange={(e) => setEmail(e.target.value)}
                />
              </label>
            </div>
            <div className="my-10 mx-4 text-center">
                <p>Genom att återställa lösenordet skickas ett nytt</p>
                <p>lösenord till den angivna mailadressen.</p>
            </div>
            <div className="flex w-full gap-2 mt-10 justify-end inset-x-0 bottom-4 mx-auto text-white">
              <button
                className="bg-blue-500 rounded text-white hover:bg-blue-600 font-bold py-2 px-4 w-full duration-300"
                type="submit"
              >
                Återställ lösenord
              </button>
              {message && <p>{message}</p>}
            </div>
          </div>
        </form>
      </div>
    </>
  );
}
