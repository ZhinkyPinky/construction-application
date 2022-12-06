import React from 'react';
import { NavLink } from 'react-router-dom';

export default function Error() {
   
  return (
    <div className='text 2x1 font-semibold flex-1 h-screen'>
      <div className='w-full'>
      <img src='404.png' alt='Error img' className='w-full' />
      </div>
      <div className='text-center mt-10'>
      <h1 className='text-4xl'>SIDAN KUNDE INTE HITTAS</h1>
      <p className='mt-6 text-2xl font-light'>Kaninerna har knaprat i kablarna igen...</p>
      <p className='mt-2 text-2xl font-light'>Kanske hjälper detta: <span className='underline text-blue-800'><NavLink to='/'>Hem</NavLink></span></p>
      </div>
    </div>
  )
}