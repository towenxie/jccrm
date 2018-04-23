function initFileInput(ctrlName,uploadUrl) {
        var control = $('#' + ctrlName);   
        control.fileinput({
        language: 'zh', 
        uploadUrl: uploadUrl, // server upload action
        uploadAsync: false,
        showUpload: false,
        showCaption: false,
        maxFileSize: 1000,
        maxFilesNum: 8,
        enctype: 'multipart/form-data',
        allowedFileExtensions : ['jpg', 'png'],
        allowedFileTypes: ['image']

    }).on('fileuploaded', function(event, data) {
    	//$("#path").attr("value",data.response);
    	if(data.response)
        {
            alert('处理成功');
        }
    }).on('filebatchuploaderror', function(event, data, msg) {
    	console.log(data.id);
    	console.log(data.index);
    	console.log(data.file);
    	console.log(data.reader);
    	console.log(data.files);
    // get message
    	alert(msg);
    }).on("filebatchuploadsuccess", function (event, data, previewId, index) {
    	console.log(data.id);
    	console.log(data.index);
    	console.log(data.file);
    	console.log(data.reader);
    	console.log(data.files);
    	var obj = data.response;
    	alert(JSON.stringify(data.success));
    });
}
