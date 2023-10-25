export interface AjaxResponse<T> {
  success: boolean;
  statusCode?: any; // Depending on what type you expect statusCode to be.
  message?: string;
  data: T;
  total?: number;
}
