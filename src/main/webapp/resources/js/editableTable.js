$(function(){
    $('td').click(function(event){
        //отслеживаем элемент, по которому кликнули
        var element         = event.target|| event.srcElement;
        var elementName     = element.tagName.toLowerCase();
        //если это input, то ничего не делаем
        if(elementName == 'input'){return false;}
        //id редактировать нельзя, типа валидатор
        if($(this).attr('name') == "idClient"){return false;}
        var val = $(this).html();
        var code = '<input type="text" id="edit" value="'+ val +'"/>';
        $(this).empty().append(code);
        $('#edit').focus();
        $('#edit').blur(function(){
            //вставить код для отметки измененных строк
            var val = $(this).val();
            $(this).parent().parent().addClass("changed");
            $(this).parent().empty().html(val);
            $('#btnSaveChanges').show();
        });
    });
});

$(window).keydown(function(event){
    if (event.keyCode == 13){
        $('#edit').blur();
    }
});

$('#btnSaveChanges').click(function(){
    arrayOfChangedContacts = [];
    $(".changed").each(function(i){
        var data = {};
        $(this).children().filter(".contact").each(function(){
            data[$(this).attr('name')] = $(this).html();
        });
        var phoneContact = {};
        $(this).children().filter(".phone").each(function(){
            phoneContact[$(this).attr('name')] = $(this).html();
        });
        var phone = "phone";
        data[phone] = phoneContact;
        arrayOfChangedContacts[i] = data;
    });

    //console.log(JSON.stringify(my_array));
    $.post('ajaxUpdate', JSON.stringify(arrayOfChangedContacts), function(response) {
        $('#btnSaveChanges').hide();
        //+ можно вставить проверку вернулось ли "true"
    }, 'json');
})
