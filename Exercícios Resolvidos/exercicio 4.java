AlertDialog.Builder builder =
        new AlertDialog.Builder(this);
builder.setMessage("Erro na aplicação, tente novamente.");
builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
});
builder.show();


//http://stackoverflow.com/questions/12139335/what-is-difference-between-dialoginterface-dismiss-and-dialoginterface-can?lq=1