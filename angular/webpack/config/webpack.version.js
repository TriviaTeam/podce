const fs = require('fs');
const path = require('path');
function pad(n) {
    return n < 10 ? '0' + n : n;
}
function getBuildDate() {
    const date = new Date();
    const result = pad(date.getDate()) + '/' + pad(date.getMonth() + 1) + '/' + date.getFullYear();
    return {
        date: result + ' ' + date.toLocaleTimeString('pt-BR', { hour12: false })
    };
}
fs.writeFile(path.join(__dirname, './../../version.json'), JSON.stringify(getBuildDate()), function (err) {
    if (err) console.log(err);
});