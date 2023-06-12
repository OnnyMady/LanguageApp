import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
  name: 'searchWordPipe'
})
export class SearchWordPipe implements PipeTransform {

  transform(value: any[], searchTextName: string, searchTextCategory: string): any[] {
    if (!value) {
      return [];
    } else {
      if (!searchTextName && !searchTextCategory) {
        return value;
      } else {
        if (searchTextName && searchTextCategory) {
          return value.filter(item => item.name.toLowerCase().includes(searchTextName)
             &&  item.category.toLowerCase().includes(searchTextCategory));
        } else {
          if (searchTextName ) {
            searchTextName = searchTextName.toLowerCase();
            return value.filter(item => item.name.toLowerCase().includes(searchTextName)
              );
          } else {
            searchTextCategory = searchTextCategory.toLowerCase();
            return value.filter(item => item.category.toLowerCase().includes(searchTextCategory));
          }
        }
      }
    }


  }

}
