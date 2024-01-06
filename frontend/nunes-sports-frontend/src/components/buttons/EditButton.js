import React from 'react';
import EditIcon from '@mui/icons-material/Edit';

function EditButton({ onClick }) {
  return (
    <button onClick={onClick} className="edit-button">
      <EditIcon />
    </button>
  );
}

export default EditButton;
