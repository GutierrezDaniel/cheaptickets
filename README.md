# cheaptickets
TAE TP

EL test utiliza firefox version: 31

link firefox 31: https://ftp.mozilla.org/pub/firefox/releases/31.0/win32/es-AR/
*************************
NOTA: 22/05/2019:
luego del dia 21/05/2019 es necesario modificar el dia que intenta registrar el test porque estan configurado para el 21/05
Codigo en cheapTiketsTest


{
      Calendars.setCalendarDay(21); <------- Remplazar fecha checkin
      CheapTikets.clickCheckOut();
      Calendars.setCalendarDay(22); <------- Remplazar fecha Checkout
}

/* En raras ocasiones la pagina de resultados de hoteles redirecciona a otra pagina distinta, al correrlo de nuevo funciona */

