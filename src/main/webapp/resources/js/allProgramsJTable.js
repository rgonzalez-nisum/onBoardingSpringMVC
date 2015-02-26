$(document).ready(function() {
    $('#allProgramsTableContainer').jtable({
        title: 'Programs',
        defaultDateFormat: 'yy-mm-dd',
        selecting: true,
        sorting: true,
        multiSorting: true,
        actions: {
            listAction: 'programs/getAllPrograms',
            createAction: 'programs/addProgram',
            updateAction: 'programs/updateProgram',
            deleteAction: 'programs/deleteProgram'
        },
        fields: {
            id: {
                title: 'ID',
                list: false,
                key: true,
                create: false,
                edit: false,
                visibility: 'hidden'
            },
            participant: {
                title: 'Participant',
                options: 'participants/getAllParticipantsAsOptions'
            },
            description: {
                title: 'Description',
                type: 'textarea'
            },
            status: {
                title: 'Status',
                options: 'statuses/getAllProgramStatusesAsOptions'
            },
            started: {
                title: 'Started on',
                type: 'date'
            }
        },
        formCreated: function (event, data) {
            data.form.find('input[name="participant"]').addClass('validate[required]');
            data.form.find('input[name="description"]').addClass('validate[required]');
            data.form.find('input[name="status"]').addClass('validate[required');
            data.form.find('input[name="started"]').addClass('validate[required,custom[date]]');
            data.form.validationEngine();
        },
        formSubmitting: function (event, data) {
            return data.form.validationEngine('validate');
        },
        formClosed: function (event, data) {
            data.form.validationEngine('hide');
            data.form.validationEngine('detach');
        },
        recordAdded: function(event, data){
            $('#allProgramsTableContainer').jtable('load');
        },
        recordUpdated: function(event, data){
            $('#allProgramsTableContainer').jtable('load');
        }
    });
    $('#allProgramsTableContainer').jtable('load');              
});