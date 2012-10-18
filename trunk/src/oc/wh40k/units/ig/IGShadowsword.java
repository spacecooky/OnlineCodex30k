package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IGShadowsword extends Eintrag {

  OptionsEinzelUpgrade o1;
  OptionsEinzelUpgrade o2;
  OptionsUpgradeGruppe o4;
  OptionsEinzelZaehler o5;
  OptionsEinzelZaehler o5x;
  OptionsUpgradeGruppe o6;

  public IGShadowsword() {
    name = "Shadowsword";
    grundkosten = 450;


    add(ico = new oc.Picture("oc/wh40k/images/Shadowsword.gif"));
    


    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
    add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zus�tzlicher Sturmbolter", 10));
    add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zus�tzliches Maschinengewehr", 10));
    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "snychr. schw. Bolter", "synchronisierter schwerer Bolter", 25));

    seperator(3);

    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Befehlspanzer", 25));

    seperator();

    ogE.addElement(new OptionsGruppeEintrag("zwei Seitenkuppeln", 0));
    ogE.addElement(new OptionsGruppeEintrag("vier Seitenkuppeln", 100));
    ogE.addElement(new OptionsGruppeEintrag("zus�tzliche Panzerplatten", 0));
    add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

    seperator();

    add(o5x = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "schwerer Bolter", 0, 0));
    add(o5 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "schwerer Flamer", "schwerer Flammenwerfer", 0, 0));

    seperator(5);

    ogE.addElement(new OptionsGruppeEintrag("Laserkanonen", 0));
    ogE.addElement(new OptionsGruppeEintrag("Zieloptik", 0));
    add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

    complete();

  }

  public void refreshen() {
    o4.alwaysSelected();

    o1.setAktiv(!o2.isSelected());
    o2.setAktiv(!o1.isSelected());

    o5.setAktiv(o4.isSelected("zwei Seitenkuppeln") || o4.isSelected("vier Seitenkuppeln"));
    o5.setMaxAnzahl(o4.isSelected("zwei Seitenkuppeln") ? 2 : 4);
    o5x.setAktiv(o4.isSelected("zwei Seitenkuppeln") || o4.isSelected("vier Seitenkuppeln"));

    o5.setMaxAnzahl(o4.isSelected("zwei Seitenkuppeln") ? 2 : 4);
    o5x.setMaxAnzahl(o5.getMaxAnzahl());
    o5x.setAnzahl(o5x.getMaxAnzahl() - o5.getAnzahl());

    o6.setAktiv(o4.isSelected("zwei Seitenkuppeln") || o4.isSelected("vier Seitenkuppeln"));
    o6.alwaysSelected();
  }
}
